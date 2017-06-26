grammar Summary;

stylesheet      : semester subject classname? '\\n'? teachers?;
semester        : SEMESTERNAME;
subject         : SEMESTERNAME | NUMBER;
classname       : SEMESTERCLASSNAME;
teacher         : NAME abbreviation;
abbreviation    : ABBR;
teachers        : teacher | (teacher '\u002F' teacher) | (teacher '/' teachers);

ABBR            : '\u0028' [a-zA-Z] [a-zA-Z] [a-zA-Z] [a-zA-Z] [a-zA-Z]?'\u0029';
SEMESTERNAME    : [a-zA-Z0-9/-]+;
MONTH           : [a-z] [a-z] [a-z];
NUMBER          :[0-9];
SUBJECTNAME     : ([a-zA-Z][a-zA-Z][a-zA-Z]) |([0-9]);
SEMESTERCLASSNAME: SEMESTERNAME (('\u0020'[a-zA-Z][a-zA-Z]?'\u0020')? | ('\u0020' [a-zA-Z]'\u002D'[a-zA-Z]?))? ('\u002D'[a-zA-Z])? '\u0020' MONTH;

NAME            : [A-Z][a-z]+'\u0020' SEMESTERNAME+?;

WS              : [ \t\r\n]+ -> skip;
