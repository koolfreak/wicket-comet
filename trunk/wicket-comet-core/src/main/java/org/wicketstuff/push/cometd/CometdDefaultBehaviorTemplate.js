function onEventFor${markupId}(message){
	
	var sxicomet = new CometWicket();
	
	if (message.data.proxy = "true")
	{
		var addToUrl = "";
		var addToMsg = "";
		var doRoundTrip = "true";
		var _isRequest = true;
		
		// test if the transaction is accepted or not
		if(message.data._accepted)
		{
			_isRequest = false;
			if(message.data._accepted == "true")
			{
				addToMsg = "The following transaction was approved:\n\n";
			}
			else
			{
				addToMsg = "The following transaction was rejected:\n\n";
			}
		}
		
		for (prop in message.data){
		    // do not make a roundtrip to server if the property is named
			// evalscript
			if(prop == "evalscript") {
			    doRoundTrip = "false";			   
			    eval(message.data[prop]);
			} else {
			    // otherwise add each property to url
				addToUrl = addToUrl + "&" + prop + "=" + message.data[prop];
				
				if(prop != "_outgoing" && prop != "proxy" && prop != "_accepted" )
				{
					addToMsg = addToMsg + prop + ":" + message.data[prop]+"\n";
				}
				
			}
		}
		
		if(_isRequest)
		{
			sxicomet.request(addToMsg);
		}
		else
		{
			sxicomet.alertOverride(addToMsg)
		}
		
		// we just call it so that the comet listener will be called
		if (doRoundTrip) {
		    var wcall=wicketAjaxGet('${url}' + addToUrl, function() { }, function() { });
		}

	}
}