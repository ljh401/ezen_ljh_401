let 작성리스트 = [];

function getCurrentDateTime() {
  let currentDate = new Date();
  let hours = String(currentDate.getHours()).padStart(2, '0');
  let minutes = String(currentDate.getMinutes()).padStart(2, '0');
  let seconds = String(currentDate.getSeconds()).padStart(2, '0');

  let currentDateTime = `${hours}:${minutes}:${seconds}`;

  return currentDateTime;
}

function 글목록() {
  let outTable = document.querySelector('.outTable');
  console.log(outTable);

  let html = `<tr>
               <th>번호</th>
               <th>제목</th>
               <th>작성자</th>
               <th>작성일</th>
               <th>조회수</th>
             </tr>`

  for (let i = 0; i < 작성리스트.length; i++) {
    let 작성글 = 작성리스트[i];
    let 번호값 = i + 1;
    let 제목값 = 작성글.제목;
    let 작성자값 = 작성글.작성자;
    let 작성일값 = 작성글.작성일;
    let 조회수 = 작성글.조회수 || 0;

    html += `<tr>
               <td>${번호값}</td>
               <td><div onclick="글보기(${i})">${제목값}</div></td>
               <td>${작성자값}</td>
               <td>${작성일값}</td>
               <td>${조회수}</td>
            </tr>`;
  }

  outTable.innerHTML = html;
}

function 글등록() {
  let writer = document.querySelector('#writer').value;
  let pwd = document.querySelector('#pwd').value;
  let title = document.querySelector('#title').value;
  let content = document.querySelector('#content').value;

  if (writer === '' || pwd === '') {
    alert('다 입력해야합니다.');
    return;
  }

  if (title === '' || content === '') {
    alert('다 입력해야합니다.');
    return;
  }

  let 작성글 = {
    작성자: writer,
    비밀번호: pwd,
    제목: title,
    내용: content,
    작성일: getCurrentDateTime(),
    조회수: 0,
  };

  작성리스트.push(작성글);
  alert('작성 성공');

  글목록();

  document.querySelector('#writer').value = '';
  document.querySelector('#pwd').value = '';
  document.querySelector('#title').value = '';
  document.querySelector('#content').value = '';
}

function 글보기(index) {
  let 작성글 = 작성리스트[index];

  작성글.조회수++;
  글목록();

  let inTable = document.querySelector('.inTable');
  let html = `
    <p>제목 : ${작성글.제목}</p>
    <p>작성자: ${작성글.작성자}</p>
    <p>작성일: ${작성글.작성일}</p>
    <p>조회수: ${작성글.조회수}</p>
    <p>${작성글.내용}</p>
    <button onclick="삭제(${index})">삭제</button>
  `;

  inTable.innerHTML = html;
}

function 삭제(index) {
  let 작성글 = 작성리스트[index];
  let 입력비밀번호 = prompt('비밀번호를 입력하세요.');

  if (작성글.비밀번호 === 입력비밀번호) {
    작성리스트.splice(index, 1);
    alert('삭제 성공');
    글목록();
    let inTable = document.querySelector('.inTable');
    inTable.innerHTML = '';
  } else {
    alert('비밀번호가 일치하지 않습니다.');
  }
}