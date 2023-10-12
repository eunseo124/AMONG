/**
 * 
 */
 
 
function deleteConfirm(id){  
    if (confirm("삭제 합니다!!") == true) location.href ="./delete?id="+id;
    else  return;
} 