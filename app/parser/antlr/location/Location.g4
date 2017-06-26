grammar Location;

stylesheet      : city? classroom city?;
city            : CITYNAME;
classroom       : locationname? CLASSNUMBER CHAR? locationname?;
locationname    : BIGCHAR;

CITYNAME        : BIGCHAR BIGCHAR;
BIGCHAR         : [A-Z];
CHAR            : [a-zA-Z] ;
CLASSNUMBER     : NUMBER NUMBER NUMBER;
NUMBER          : [0-9];
WS              : [ \t\r\n]+ -> skip;
