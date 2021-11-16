function add(){
    let data = $('#add').serialize();
    $.ajax({
        method: "POST",
        url: "api/add",
        data:  data
    });
    setTimeout('window.location.reload()',200);
}

function del(id){
    $.ajax({
        method: "DELETE",
        url: "/api/del/" + id,
    });
    setTimeout('window.location.reload()',200);
}

function upd() {
    let data = $('#updElement').serialize();
    $.ajax({
        method: "PUT",
        url: "/api/upd",
        data: data
    });
    setTimeout('window.location.reload()',200);
}

function get(id){
    $.ajax({
        method: "GET",
        url: "/api/" + id,
        success: function (response){
            return response;
        }
    });
    setTimeout('window.location.reload()',200);
}
function getAll(){
    $.ajax({
        method: "GET",
        url: "api/getAll",
        success: function (response){
            return response;
        }
    })
}
