define("newweb/common/service", ["./utils", "./md5", "./jquery-1.7"], function(e, t) {
    var n = e("./jquery-1.7");
    e("./utils");
    e("./md5");
    var r = function(e) {
        var t = n.md5(navigator.appVersion)
            , r = "" + (new Date).getTime()
            , i = r + parseInt(10 * Math.random(), 10);
        return {
            ts: r,
            bv: t,
            salt: i,
            sign: n.md5("fanyideskweb" + e + i + "]BjuETDhU)zqSxf-=B#7m")
        }
    };


})