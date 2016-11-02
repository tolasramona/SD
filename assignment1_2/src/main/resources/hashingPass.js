
function hashPassword(password) {
	var maskList = [ "dfgrert2341", "435fgdfg)(f", "89dsfer435", "dfdtu67922",
			"fth454vA", "23A==rtrtfg", "HI980Bxcfgh!!" ];
	var maskListLength = maskList.length;
	var mapForOperation = maskList[(password.length) % maskListLength];
	var passWithSalt = password+mapForOperation ;
	var hash = 0, i, chr, len;
	  if (passWithSalt.length === 0) return hash;
	  for (i = 0, len = passWithSalt.length; i < len; i++) {
	    chr   = passWithSalt.charCodeAt(i);
	    hash  = ((hash << 5) - hash) + chr;
	    hash |= 0;
	  }
	 
	var hashedPassword = hash.toString(16)+"";
	return hashedPassword;
}