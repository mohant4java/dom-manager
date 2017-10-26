var mainModule = angular.module("main",["ui.router","ngTable","mainServices"]);


mainModule.config(function($stateProvider,$urlRouterProvider) {
    $stateProvider.state({
                             name: 'about',
                             url: '/about',
                             templateUrl: '/about.html'
                           })
                   .state({
                             name: 'flats',
                             url: '/flats',
                             templateUrl: '/flats.html',
                             controller : 'AllFlatsController'
                           })
                    .state({
                        name: 'income',
                        url : "/income" ,
                        templateUrl : "/income.html",
                        controller : "TreasuryController"
                    });

    $urlRouterProvider.otherwise('/flats');

});

mainModule.controller("AllFlatsController",
            function($scope,FlatService){
            $scope.flats=[]
                $scope.refresh = function(){

                    $scope.loading = true;
                    $scope.flats = FlatService.query(function(){
                                                           // success handler
                                                          $scope.loading = false
                                                         }
                                                     );


                }
                $scope.saveFlat = function(newFlat){
                    FlatService.save(newFlat, function(resp,headers){
                            // success handler
                            console.log(resp)
                            var found = false;
                            for(var i =0; i<$scope.flats.length; i++){
                                if($scope.flats[i].name == newFlat.name){
                                    found = true;
                                }
                            }
                            if(! found){
                                $scope.flats.push(newFlat)
                            }

                        },
                        function(resp){
                            // error handler
                            console.log(resp)

                        }
                    )
                }

                $scope.refresh ();

            }
        )
        .controller("TreasuryController", function($scope, TreasuryService, MaintenanceService, TransactionService, NgTableParams){
            $scope.status = "";
            $scope.transactions = TransactionService.query({status:$scope.status})
            console.log($scope.transactions)
            $scope.addMaintenance = function(maintenance){
                MaintenanceService.save(maintenance,function(data){
                    console.log(data)
                },function(data){
                    console.log(data)
                })
            }

            $scope.tableParams = new NgTableParams({}, {
                  getData: function(params) {
                    // ajax request to api
                    return TransactionService.get({status:$scope.status}).$promise.then(
                        function(data){
                            //params.total(data.inlineCount);
                            return data.results;
                        }
                    );
                  }
                });

        })




