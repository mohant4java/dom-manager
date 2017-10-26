angular.module('mainServices',["ngResource"])
    .factory('FlatService', function($resource) {
         return $resource('/rest/flat'); // Note the full endpoint address
    })
    .factory('TreasuryService',function($resource){
        return $resource ('/rest/treasury')
    })
    .factory('MaintenanceService',function($resource){
            return $resource ('/rest/treasury/maintenance',{
                month: '@month',
                sftRate: "@sftRate"
            })
        })

    .factory('TransactionService',function($resource){
                return $resource ('/rest/treasury/transactions',{
                    status: '@status'
                })
            })
        ;
