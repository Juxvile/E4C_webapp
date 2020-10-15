// Маска номера телефона
$("#phone").mask("+375(99)999-99-99");
// Маска для ввода даты
$( function() {
    $("#datepicker").datepicker({minDate: 'today'});

} );

(function(){
    Array.prototype.forEach.call(document.querySelectorAll('.selected'), function(e){
        e.addEventListener("change", n)
    })

    function n(e) {
        let s = e.target;
        let v = s.parentNode.querySelector('.value');

        !+s.value && (v.style.display = 'none') || (v.style.display = 'block', v.innerText = s.value)
    }
})();