function add(){
    let data = $('#add').serialize();
    $.ajax({
        method: "POST",
        url: "api/add",
        data:  data
    });
    window.location.reload();
}

function upd(id) {
    let data_id = "#upd" + id

    let data = $(data_id).serialize();
    $.ajax({
        method: "PUT",
        url: "api/update",
        data: data
    });
    location.reload()
}

function getDataInDiagram(){

    $.ajax({
        method: "GET",
        url: "/api/getDataInDiagram",
        success: function (response){
            startDiagram(response);
        }
    });

}
