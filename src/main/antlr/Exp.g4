grammar Exp;

input: expression EOF;

expression
    : Number
    | Boolean
    | Not expression
    | expression Mul expression
    | expression Add expression
    | expression Cmp expression
    | expression Eq expression
    | expression And expression
    | expression Or expression
    | '(' + expression + ')'
    ;

Number
    :    ('+'|'-')?('0'..'9')+ ('.' ('0'..'9')+)?
    ;

Boolean
    :'true'
    | 'false'
    ;

Add
    : '+'
    | '-'
    ;

Mul
    : '*'
    | '/'
    | '%'
    ;
Cmp
    : '<'
    | '<='
    | '>'
    | '>='
    ;

Eq
    : '=='
    | '!='
    ;

And : '&&';

Or : '||';

Not: '!';

WS : (' ' | '\t' | '\r'| '\n') -> skip;