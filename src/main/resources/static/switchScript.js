/**
 * Created by Michał Treter on 03.06.2017.
 */
function changeHand(elemId){
    var clickedID = parseInt(elemId);
    if(document.getElementById((clickedID)).style.color === "grey" || document.getElementById((clickedID)).style.color === "red" || document.getElementById((clickedID)).style.color === "green"){
        return false;
    }
    if(clickedID % 2 === 0){
        document.getElementById(clickedID).style.color = "red";
        document.getElementById((clickedID + 1)).style.color = "grey";
    }
    else{
        document.getElementById(clickedID).style.color = "green";
        document.getElementById((clickedID - 1)).style.color = "grey";
    }

}