function CometWicket()
{
	
}

CometWicket.prototype.request = function(msg) {
	var conf = confirm(msg.ReplaceAll("#","\n"));
	if(conf)
	{
		//true here
		listoverride();
	}
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