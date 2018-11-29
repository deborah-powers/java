chrome.tabs.query (
	{
		active: true,
		currentWindow: true
	},
	function (tabs){
		var printUrl = document.getElementById ('url');
		var printTitle = document.getElementById ('title');
		printUrl.innerHTML = tabs[0].url;
		printTitle.innerHTML = tabs[0].title;
	}
);