
~~~~ Js
function solution(msg) {
    var answer = [];
    var Alphabet = [
        'A', 'B', 'C', 'D', 'E', 'F',
        'G', 'H', 'I', 'J', 'K', 'L',
        'M', 'N', 'O', 'P', 'Q', 'R',
        'S', 'T', 'U', 'V', 'W', 'X',
        'Y', 'Z'
    ]
    
    var count = 0;
    for(var i=Alphabet.length; i>=0; i--){
        var pos = msg.indexOf(Alphabet[i]);
        if(pos == 0){
            answer[count] = i+1
            msg = msg.substring(Alphabet[i].length) // 알파벳 크기 자름
            // 알파벳 + msg0번 합쳐서 Alphabet[]에 저장
            Alphabet[Alphabet.length] = Alphabet[i]+msg.charAt(0) 
            i = Alphabet.length;
            count++
        }
    }
    return answer;
}
~~~~