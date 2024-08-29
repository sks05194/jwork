<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>
<script>
    function addFileFnc() {
        let fileAttr = Number(document.getElementById("addFileBtn").previousSibling.getAttribute("name").replace("filename", "")) + 1;
        console.log(document.getElementById("addFileBtn").previousSibling);

        let filesLength = document.querySelectorAll("input[type=file]").length;
        
        // let btn = document.getElementById("addFileBtn").cloneNode(true); // 쓸모없는 작업
        document.getElementById("addFileBtn").remove();

        let ptag = document.createElement("p");
        ptag.innerHTML = '파일: <input type="file" name="filename' + (fileAttr) + '"><button type="button" id="addFileBtn" onclick="addFileFnc()">버튼 추가</button>';

        document.getElementById("filesDiv").appendChild(ptag);

        if (filesLength == 4) document.getElementById("addFileBtn").remove();
    }

    let extArr = ["jpg", "png", "gif", "jpeg", "svg", "bmp", "webp"];

    window.onload = function () {
        fileForm.addEventListener('submit', function (e) {
            let lenTF = false, extTF = false;
            let attrStr = document.querySelector("input[type=file]").getAttribute('multiple');
            let cnt = 0;
            let imgs;

            if (attrStr == 'multiple') {
                // .files => 업로드한 파일들을 파일배열 형식으로 가져오는 속성
                // multiple 속성이 존재하는 input type="file"만 가능
                imgs = document.querySelector("input[type=file]").files;
                for (let i = 0; i < imgs.length; i++) {
                    let filename = imgs[i].name;
                    let extension = filename.substring(filename.lastIndexOf(".") + 1);
                    extArr.forEach(function (obj) {
                        if (obj == extension.toLowerCase()) cnt++;
                    });
                }
            } else {
                imgs = document.querySelectorAll("input[type=file]");
                for (let i = 0; i < imgs.length; i++) {
                    let filename = imgs[i].files[0].name;
                    let extension = filename.substring(filename.lastIndexOf(".") + 1);
                    extArr.forEach(function (obj) {
                        if (obj == extension.toLowerCase()) cnt++;
                    });
                }
            }

            if (cnt != imgs.length) alert("이미지 파일만 업로드 하실 수 있습니다.");
            else extTF = true;

            let filesLength = imgs.length;
            if (filesLength > 5) alert("파일은 최대 5개까지만 업로드할 수 있습니다.");
            else lenTF = true;

            if (!(lenTF && extTF)) e.preventDefault(); // 기본이벤트 방지
        });
    };
</script>
</head>
<body>
    <h2>MultipartRequest를 이용한 파일 업로드</h2>

    <dl>
        <dd>
            - cos.jar 파일 필요:
            <a href="https://mvnrepository.com/artifact/com.servlets/cos/05Nov2002">다운받기</a>
        </dd>
    </dl>
    <form name="fileForm" method="post" enctype="multipart/form-data" action="11_01_fileupload01_process.jsp">
        <fieldset name="fld">
            <legend>파일 업로드 폼</legend>
            <p>이름: <input type="text" name="name"></p>
            <p>제목: <input type="text" name="subject"></p>
            <!-- <p> -->
                <!-- <input type="checkbox" name="servlets" value="가">가 -->
                <!-- <input type="checkbox" name="servlets" value="나">나 -->
                <!-- <input type="checkbox" name="servlets" value="다">다 -->
            <!-- </p> -->
            <div id="filesDiv">
                <p>파일: <input type="file" name="filename" multiple="multiple"></p>
                <!-- <p>파일: <input type="file" name="filename1"><button type="button" id="addFileBtn" onclick="addFileFnc()">버튼 추가</button></p> -->
            </div>
            <p><input type="submit" value="파일 올리기"></p>
        </fieldset>
    </form>
</body>
</html>