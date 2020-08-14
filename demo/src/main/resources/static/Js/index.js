/**
 * Created by Administrator on 2020/7/24 0024.
 */
    $(document).ready(function() {
        $(".box1").click(function(){
            $(this).addClass("back")
                .children("a").show().end()
                .siblings().removeClass("back")
                .children("a").hide();
        })
        });

    window.onload = function () {
    var discoverdiv = document.getElementById("a1"); // 方式1 a标签.
    var discoverdiv1 = document.getElementById("a2");
    var discoverdiv2 = document.getElementById("a3");
    var discoverdiv3 = document.getElementById("a4");
    var div1 =document.getElementById("div1");
    var div2 =document.getElementById("div2");
    var div3 =document.getElementById("div3");
    var div4 =document.getElementById("div4");
    var div5 =document.getElementById("div5");

    discoverdiv.onclick = function () {
        if(true) {
            //alert("绑定click");
            div2.style.display = 'none';
            div3.style.display = 'none';
            div4.style.display = 'none';
            div5.style.display = 'none';

            div1.style.display = 'block';
        }else{
            div1.style.display = 'none';
        }
    }
    discoverdiv1.onclick = function () {
        if(true) {
            //alert("绑定click");
            div1.style.display = 'none';
            div3.style.display = 'none';
            div4.style.display = 'none';
            div5.style.display = 'none';

            div2.style.display = 'block';
        }else{
            div2.style.display = 'none';
        }
    }
    discoverdiv2.onclick = function () {
        if(true) {
            // alert("绑定click");
            div1.style.display = 'none';
            div2.style.display = 'none';
            div4.style.display = 'none';
            div5.style.display = 'none';

            div3.style.display = 'block';
        }else{
            div3.style.display = 'none';
        }
    }
    discoverdiv3.onclick = function () {
        if(true) {
            // alert("绑定click");
            div1.style.display = 'none';
            div2.style.display = 'none';
            div3.style.display = 'none';
            div5.style.display = 'none';

            div4.style.display = 'block';
        }else{
            div4.style.display = 'none';
        }
    }
}

    //默认提交状态为false
    var commitStatus = false;
    
    function dosubmit(){
          if(commitStatus==false){
        //提交表单后，讲提交状态改为true
          commitStatus = true;
          return true;
         }else{
          return false;
      }
     }