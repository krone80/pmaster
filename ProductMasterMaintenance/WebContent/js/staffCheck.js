$(function(){
	$('form').on('submit', function() {
		var i = 0;
		var errMsg = "";
		var idLength = 10;
		var passLength = 40;
		var value = null;
		//社員IDの入力チェック
		if(value != null && value != "") {
			if(value.length > idLength) {
				errMsg += "社員IDは" + idLength + "文字までで入力してください\n";
				i++;
			}
		} else {
			errMsg += "社員IDが未入力です\n";
			i++;
		}
		//パスワードの入力チェック
		if(value != null && value != "") {
			if(value.length > idLength) {
				errMsg += "パスワードは" + passLength + "文字までで入力してください\n";
				i++;
			}
		} else {
			errMsg += "パスワードが未入力です\n";
			i++;
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
