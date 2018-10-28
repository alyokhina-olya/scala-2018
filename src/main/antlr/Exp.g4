grammar Exp;


expr returns [double value]
    : EOF {$value = 0;}
    |Number {$value=Double.parseDouble($Number.text);}
    | 'true' {$value=1;}
    | 'false' {$value=0;}
    | '(' + expression = expr + ')' {$value = $expression.value;}
    | '!' expression = expr {$value = ($expression.value == 0) ? 1 : 0;}
    | left = expr op = '*' right = expr{$value = $left.value * $right.value;}
    | left = expr op = '/' right = expr{$value = $left.value / $right.value;}
    | left = expr op = '%' right = expr{$value = $left.value % $right.value;}
    | left = expr op = '+'right = expr{$value = $left.value + $right.value;}
    | left = expr op = '-' right = expr{$value = $left.value - $right.value;}
    | left = expr op = '<' right = expr{$value = ($left.value < $right.value) ? 1 : 0;}
    | left = expr op = '>' right = expr{$value = ($left.value > $right.value) ? 1 : 0;}
    | left = expr op = '<=' right = expr{$value = ($left.value <= $right.value) ? 1 : 0;}
    | left = expr op = '>=' right = expr{$value = ($left.value >= $right.value) ? 1 : 0;}
    | left = expr op = '==' right = expr{$value = ($left.value == $right.value) ? 1 : 0;}
    | left = expr op = '!=' right = expr{$value = ($left.value != $right.value) ? 1 : 0;}
    | left = expr op = '&&' right = expr{$value = ($left.value == 0 || $right.value == 0) ? 0 : 1;}
    | left = expr op = '||' right = expr{$value = ($left.value == 0 && $right.value == 0) ? 0 : 1;}
    ;

Number
    :    ('+'|'-')?('0'..'9')+ ('.' ('0'..'9')+)?
    ;

WS : (' ' | '\t' | '\r'| '\n') -> skip;