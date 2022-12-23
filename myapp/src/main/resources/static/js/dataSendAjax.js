//form데이터 전송
function dataSubmit() {
	if ($('#img_upload')[0].files.length >= 4) {
		alert("첨부 가능한 개수를 초과하였습니다. 3개 까지 첨부가 가능합니다.");
	    return false;
	}
	var form = $("#addForm")[0]; 
    var data = new FormData(form);
 
    $.ajax({
        url: "/ajax/url.do",
        type: "POST",
        enctype: 'multipart/form-data',
        data: data,
        processData: false,
        contentType: false,
        cache:false,
        dataType:"json",
    }).done(function (fragment) {
        $("#resultDiv").replaceWith(fragment);
    });
}
