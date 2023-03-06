function setup() {
    noCanvas();
    
}

btn.addEventListener('click',function(){
    let lang = navigator.language || 'en-US';
    let speechRec = new p5.SpeechRec(lang, gotSpeech);
  
    let continuous = true;
    let interimResults = false;
    speechRec.start(continuous, interimResults);
    let text = document.getElementById("text")
  
    function gotSpeech() {
        if (speechRec.resultValue) {
            let said = speechRec.resultString;
            text.textContent += " " + said;
      }}
})