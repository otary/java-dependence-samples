grammar Expr;

fragment Digits
    : [0-9] ([0-9_]* [0-9])?
    ;
INT:    ('0' | [1-9] (Digits? | '_'+ Digits));

prog: expr EOF;
expr: expr ('*'|'/') expr  #MultiOrDiv
    | expr ('+'|'-') expr  #AddOrSub
    | INT     #Lieteral
    | '(' expr ')'   #Single
    ;
NEWLINE : [\r\n]+ -> skip;

