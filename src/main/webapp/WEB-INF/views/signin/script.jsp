<script type="text/javascript">
	$(document).ready(function() {
		var button = $('#submit-btn');
		button.off("click");
		button.click(function() {
			try {
  			if ($('.hint').size() > 0) {
  				window.alert('Please fill in form');
  			} else {
  				$.postJSON(
  						'signin',
  						{
  							'username' : $('#username').val(),
  							'password' : $('#password').val(),
  							'nonce' : $('#nonce').val(),
  			        'sessionId' : $('#sessionId').val()
  						},
  						function(data) {
  			        if (data.status == 'OK') {
  			          $('#login-msg').text(data.message);
  			          try {
  			        	  
  			          button.attr('disabled', 'disabled');
  			          button.addClass('disabled');
  			          } catch (e) {
  			        	  window.alert(e);
  			          }
  			        } else {
  			          window.alert(data.message);
  			        }
  			      }
  					);
  			}
			} catch(e) {
				windows.alert(e);
			} finally {
				return false;
			}
		});

	});
</script>
