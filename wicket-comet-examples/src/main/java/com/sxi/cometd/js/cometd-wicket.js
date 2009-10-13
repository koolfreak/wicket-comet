function CometWicket()
{
	
}

CometWicket.prototype.request = function(msg) {
	var conf = confirm(msg);
	if(conf)
	{
		//true here
		listoverride();
	}
}

CometWicket.prototype.alertOverride = function(msg) {
	alert(msg);
}

String.prototype.ReplaceAll = function(stringToFind,stringToReplace){
    var temp = this;
    var index = temp.indexOf(stringToFind);
        while(index != -1){
            temp = temp.replace(stringToFind,stringToReplace);
            index = temp.indexOf(stringToFind);
        }
        return temp;
    }