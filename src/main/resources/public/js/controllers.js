angular.module('app.controllers', []).controller('QuestionListController', function($scope, $state, popupService, $window, Question) {
  $scope.questions = Question.query(); //fetch all questions. Issues a GET to /api/vi/questions

  $scope.deleteQuestion = function(question) { // Delete a Question. Issues a DELETE to /api/questions/:id
    if (popupService.showPopup('Really delete this?')) {
      question.$delete(function() {
        $scope.questions = Question.query(); 
        $state.go('questions');
      });
    }
  };
}).controller('QuestionViewController', function($scope, $stateParams, Question) {
  $scope.question = Question.get({ id: $stateParams.id }); //Get a single question.Issues a GET to /api/questions/:id
}).controller('QuestionCreateController', function($scope, $state, $stateParams, Question) {
  $scope.question = new Question();  //create new question instance. Properties will be set via ng-model on UI

  $scope.addQuestion = function() { //create a new question. Issues a POST to /api/questions
    $scope.question.$save(function() {
      $state.go('questions'); // on success go back to the list i.e. questions state.
    });
  };
}).controller('QuestionEditController', function($scope, $state, $stateParams, Question) {
  $scope.updateQuestion = function() { //Update the edited question. Issues a PUT to /api/questions/:id
    $scope.question.$update(function() {
      $state.go('questions'); // on success go back to the list i.e. questions state.
    });
  };

  $scope.loadQuestion = function() { //Issues a GET request to /api/questions/:id to get a question to update
    $scope.question = Question.get({ id: $stateParams.id });
  };

  $scope.loadQuestion(); // Load a question which can be edited on UI
});
