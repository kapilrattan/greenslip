var phonemodels = new Bloodhound({
    datumTokenizer: function (datum) {
        return Bloodhound.tokenizers.whitespace(datum.value);
    },
    queryTokenizer: Bloodhound.tokenizers.whitespace,
    remote: {
        url: 'http://localhost:8080/receipt/DropdownResourceServlet?action=get&resource=phonemodel&resourceValue=%QUERY',
        wildcard: '%QUERY',
        filter: function (phonemodels) {
            console.log(phonemodels);
            // Map the remote source JSON array to a JavaScript object array
            return $.map(phonemodels.results, function (phonemodel) {
                return {
                    value: phonemodel.value,
                    release_date: phonemodel.id
                };
            });
        }
    },
    limit: 10
});

// Initialize the Bloodhound suggestion engine
phonemodels.initialize();

// Instantiate the Typeahead UI
$('#scrollable-dropdown-menu .typeahead').typeahead(null, {
    displayKey: 'value',
    source: phonemodels.ttAdapter(),
    templates: {
        empty: [
            "<p align='center'><b>",
            "<a id='myLink' title='Click to do something' href='#' onclick='addPhoneModelWindow()' align='center'>Add New</a>",
            "</b></p>"
        ].join("\n"),
        suggestion: Handlebars.compile("<p style='padding:6px'><b>{{value}}</b></p>"),
        footer: Handlebars.compile("<p align='center'><b><a id='myLink' title='Click to do something' href='#' onclick='addPhoneModelWindow()'>Add New</a></b></p>")
    }

});



function addPhoneModelWindow() {
    var modal = document.getElementById('phoneModelModal');
    modal.style.display = "block";
}
;
function closePhoneModelWindow(){
    var modal = document.getElementById('phoneModelModal');
    modal.style.display = "none";
}
; 