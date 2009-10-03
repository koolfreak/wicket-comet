



if(typeof(sxicometd) == "undefined")
{
	sxicometd = {}
}

sxicometd.confirm = {
		cometconfirm: function(msg) {
		alert(msg);
	}
}

sxicometd.jsonclient = {
	parse: function(jsontxt){
		var fStr = '';
		JSON.parse(jsontxt, function(key,value) {
			if (value && typeof value == 'string') {
				fStr += processData(key, value);
			}
		});
		return fStr;
	}
	,
	processData: function(key,value){
		return key +": "+value+"\n";
	}
}

sxicometd.override = {
	approve: function(jsontext){
		alert(jsontext.ReplaceAll("#","\n"));
	}
	,
	reject: function(jsontext){
		alert(jsontext.ReplaceAll("#","\n"));
	}
	
}

sxicometd.alerts = {
		success: function(jsontext){
			alert(jsontext.ReplaceAll("#","\n"));
		}
		,
		failed: function(jsontext){
			alert(jsontext.ReplaceAll("#","\n"));
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


