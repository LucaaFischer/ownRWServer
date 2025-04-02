function paint(color) {
    const circle = document.getElementById('circleID');
    if(color != "random") {
        circle.style = `background-color:${color}`;
    }
    else {
        randColor = getRndInteger(1, 3);
        if (randColor == 1) {
            circle.style = `background-color:${"red"}`;
        } else if (randColor == 2) {
            circle.style = `background-color:${"green"}`;
        } else {
            circle.style = `background-color:${"yellow"}`;
        }
    } 
  }

  function yap() {
    document.writeln("UwU");
  }

  function getRndInteger(min, max) {
    return Math.floor(Math.random() * (max - min + 1) ) + min;
  }
  