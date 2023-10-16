/**
 * 
 */
 
 
function deleteConfirm(id){  
    if (confirm("회원정보를 삭제합니다.") == true) location.href ="./delete?id="+id;
    else  return;
}

