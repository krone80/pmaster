$(function(){
	$('form').on('submit', function() {
		var i = 0;
		var errMsg = "";
		var idLength = 8;
		var nameLength = 50;
		var valLength = 8;
		var value = null;
		//商品コードの入力チェック
		value = $('input[name="productId"]').val();
		if(value != null && value != "") {
			if(value.length > idLength) {
				errMsg += "商品コードは" + idLength + "文字までで入力してください\n";
				i++;
			}
		} else {
			errMsg += "商品コードが未入力です\n";
			i++;
		}
		//商品名の入力チェック
		value = $('input[name="productName"]').val();
		if(value != null && value != "") {
			if(value.length > nameLength) {
				errMsg += "商品名は" + nameLength + "文字までで入力してください\n";
				i++;
			}
		}
		//単価の入力チェック
		value = $('input[name="productVal"]').val();
		if(value != null && value != "") {
			if(value != null && value.length > valLength) {
				errMsg += "単価は" + valLength + "桁までで入力してください\n";
				i++;
			}
		}
		//エラーをアラートで出力
		if(i > 0){
			alert("エラー\n" + errMsg);
			return false;
		} else {
			return true;
		}
	});
});
