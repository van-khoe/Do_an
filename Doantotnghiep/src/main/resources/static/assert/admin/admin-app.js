app = angular.module("admin-app", ["ngRoute"]);
app.config(function ($routeProvider){
    $routeProvider
    .when("/vaccine",{
        templateUrl: "/assert/admin/loaivaccin/index.html",
        controller: "loaivaccin"
    })
    .when("/user",{
        templateUrl: "/assert/admin/user/index.html",
        controller: "user-ctrl"
    })
    .when("/vaccination_card",{
        templateUrl: "/assert/admin/vaccination_card/index.html",
        controller: "vaccination_card_ctrl"
    })
    .when("/role",{
        templateUrl: "/assert/admin/role/index.html",
        controller: "role-ctrl"
    })
    .when("/authority",{
        templateUrl: "/assert/admin/tiemchung/index.html",
        controller: "tiemchung"
    })
    
    .otherwise({
        templateUrl: "/assert/admin/home.html"
    });
})