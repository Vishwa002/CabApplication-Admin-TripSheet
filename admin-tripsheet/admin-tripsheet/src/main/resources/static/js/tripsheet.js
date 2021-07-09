







var xhr = new XMLHttpRequest();
xhr.onreadystatechange = function() {
	if (this.readyState == 4 && this.status == 200) {

		document.getElementById("").innerHTML = this.responseText;
	}
};
xhr.open("GET", "", true);
xhr.send();
