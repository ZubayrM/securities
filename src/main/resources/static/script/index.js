chart = anychart.area();

window.onload = function (){
    getDataInDiagram();
}


function startDiagram(newData){
    let list = newData;
    console.log(list)

    if (list === undefined){
        alert("не судьба")
    }else {
        for (i = 0; i < list.length; i++){
            let data = list[i]
            addToDiagram(data.list, data.name)
        }
    }

}







function addToDiagram(date, name){
    let series = chart.area(date)
    series.name(name)
}



chart.legend().enabled(true).fontSize(13).padding([30, 30, 30, 30])
chart.container("container");
chart.draw();