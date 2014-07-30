function addHint(field, text) {
	addHintFocusHandler(field, text);
	field.blur(function() {
		if (field.val()) {
			field.off('focus');
		} else {
			addHintFocusHandler(field, text);
		}
	});
}

function addHintFocusHandler(field, text) {
	field.addClass('hint');
	field.val(text);
	field.on('focus', function() {
		field.val('');
		field.removeClass('hint');
	});
}

$.postJSON = function(url, data, callback) {
	$.ajax({
		'headers' : {
			'Accept' : 'application/json',
			'Content-Type' : 'application/json'
		},
		'type' : 'POST',
		'url' : url,
		'data' : JSON.stringify(data),
		'success' : callback,
		'dataType' : 'json'
	});
}