/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Instantiate the Bloodhound suggestion engine
var movies = new Bloodhound({
    datumTokenizer: function (datum) {
        return Bloodhound.tokenizers.whitespace(datum.value);
    },
    queryTokenizer: Bloodhound.tokenizers.whitespace,
    remote: {
        url: 'http://api.themoviedb.org/3/search/movie?query=%QUERY&api_key=f22e6ce68f5e5002e71c20bcba477e7d',
        wildcard: '%QUERY',
        filter: function (movies) {
            console.log(movies);
            // Map the remote source JSON array to a JavaScript object array
            return $.map(movies.results, function (movie) {
                return {
                    value: movie.original_title,
                    release_date: movie.release_date
                };
            });
        }
    },
    limit: 10
});

// Initialize the Bloodhound suggestion engine
movies.initialize();

// Instantiate the Typeahead UI
$('#scrollable-dropdown-menu .typeahead').typeahead(null, {
    displayKey: 'value',
    source: movies.ttAdapter(),
    templates: {
        empty: [
            "<div class='empty-message'>",
            "<a id='myLink' title='Click to do something' href='#' onclick='addNewWindow()'>Add New</a>",
            "</div>"
        ].join("\n"),
        suggestion: Handlebars.compile("<p style='padding:6px'><b>{{value}}</b></p>"),
        footer: Handlebars.compile("<a id='myLink' title='Click to do something' href='#' onclick='addNewWindow()'>Add New</a>")
    }

});

function addNewWindow() {
    alert("Hello !!!!!");
    //	window.showModalDialog("example.hrml");
}
