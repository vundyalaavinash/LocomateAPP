$(document).ready(
		function() {
			$('#imagefile').change(
					function(e) {
						var f = e.originalEvent.target.files[0];
						if (!f.type.match('image.*')) {
							alert(" only Image Files allowed! ");
						} else {
							var reader = new FileReader();
							reader.onload = (function(theFile) {
								return function(e) {
									var span= $(['<img class="thumb" class="imagehundredPer" src="',e.target.result, '" title="',escape(theFile.name), '"/>' ].join(''));
									$(".list").append(span);
								};
							})(f);
							reader.readAsDataURL(f);
						}
					});
		});