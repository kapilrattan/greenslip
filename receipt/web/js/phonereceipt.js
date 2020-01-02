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

var photoidtypes = new Bloodhound({
    datumTokenizer: function (datum) {
        return Bloodhound.tokenizers.whitespace(datum.value);
    },
    queryTokenizer: Bloodhound.tokenizers.whitespace,
    remote: {
        url: 'http://localhost:8080/receipt/DropdownResourceServlet?action=get&resource=photoidtype&resourceValue=%QUERY',
        wildcard: '%QUERY',
        filter: function (photoidtypes) {
            console.log(photoidtypes);
            // Map the remote source JSON array to a JavaScript object array
            return $.map(photoidtypes.results, function (photoidtype) {
                return {
                    value: photoidtype.value,
                    release_date: photoidtype.id
                };
            });
        }
    },
    limit: 10
});

// Initialize the Bloodhound suggestion engine
photoidtypes.initialize();

var phonemakes = new Bloodhound({
    datumTokenizer: function (datum) {
        return Bloodhound.tokenizers.whitespace(datum.value);
    },
    queryTokenizer: Bloodhound.tokenizers.whitespace,
    remote: {
        url: 'http://localhost:8080/receipt/DropdownResourceServlet?action=get&resource=phonemake&resourceValue=%QUERY',
        wildcard: '%QUERY',
        filter: function (phonemakes) {
            console.log(phonemakes);
            // Map the remote source JSON array to a JavaScript object array
            return $.map(phonemakes.results, function (phonemake) {
                return {
                    value: phonemake.value,
                    release_date: phonemake.id
                };
            });
        }
    },
    limit: 10
});

// Initialize the Bloodhound suggestion engine
phonemakes.initialize();
// Instantiate the Typeahead UI
$('#scrollable-dropdown-menu-phonemodel .typeahead').typeahead(null, {
    displayKey: 'value',
    source: phonemodels.ttAdapter(),
    templates: {
        empty: [
            "<p align='center'><b>",
            "<a id='myLink' title='Click to do something' href='#' onclick='addPhoneModelWindow()' align='center'>Cannot find it</a>",
            "</b></p>"
        ].join("\n"),
        suggestion: Handlebars.compile("<p style='padding:6px'><b>{{value}}</b></p>"),
//        footer: Handlebars.compile("<p align='center'><b><a id='myLink' title='Click to do something' href='#' onclick='addPhoneModelWindow()'>Add New</a></b></p>")
    }

});

$('#scrollable-dropdown-menu-phonemake .typeahead').typeahead(null, {
    displayKey: 'value',
    source: phonemakes.ttAdapter(),
    templates: {
        empty: [
            "<p align='center'><b>",
            "<a id='myLink' title='Click to do something' href='#' onclick='addPhoneMakeWindow()' align='center'>Add New</a>",
            "</b></p>"
        ].join("\n"),
        suggestion: Handlebars.compile("<p style='padding:6px'><b>{{value}}</b></p>"),
        footer: Handlebars.compile("<p align='center'><b><a id='myLink' title='Click to do something' href='#' onclick='addPhoneMakeWindow()'>Add New</a></b></p>")
    }

});
$('#scrollable-dropdown-menu-photoidtype .typeahead').typeahead(null, {
    displayKey: 'value',
    source: photoidtypes.ttAdapter(),
    templates: {
        empty: [
            "<p align='center'><b>",
            "<a id='myLink' title='Click to do something' href='#' onclick='addPhotoIdTypesWindow()' align='center'>Add New</a>",
            "</b></p>"
        ].join("\n"),
        suggestion: Handlebars.compile("<p style='padding:6px'><b>{{value}}</b></p>"),
        footer: Handlebars.compile("<p align='center'><b><a id='myLink' title='Click to do something' href='#' onclick='addPhotoIdTypesWindow()'>Add New</a></b></p>")
    }

});


function addPhoneModelWindow() {
    var modal = document.getElementById('phoneModelModal');
    modal.style.display = "block";
}
;

function submitPhoneModelWindow(){
    document.getElementById('frm_phonedetails:phoneModel').value = document.getElementById('frmPhoneModel:phoneModelValue').value ; 
    closePhoneModelWindow(); 
}
;
function closePhoneModelWindow(){
//    document.getElementById('phoneModel').value = document.getElementById('phoneModelValue').value ; 
    var modal = document.getElementById('phoneModelModal');
    modal.style.display = "none";
}
; 
function addPhoneMakeWindow() {
    var modal = document.getElementById('phoneMakeModal');
    modal.style.display = "block";
}
;

function submitPhoneMakeWindow(){
    var makeValue =  document.getElementById('frmPhoneMake:phoneMakeValue').value ; 
    alert("Make Value ["+makeValue+"]"); 
    document.getElementById('frm_phonedetails:phoneMake').value = makeValue ; 
    closePhoneMakeWindow(); 
}
;

function closePhoneMakeWindow(){
    var modal = document.getElementById('phoneMakeModal');
    modal.style.display = "none";
}
; 

function addPhotoIdTypesWindow() {
    var modal = document.getElementById('photoIdTypeModal');
    modal.style.display = "block";
}
;
function submitPhotoIdTypeWindow(){
    document.getElementById('frm_phonedetails:sellerPhotoIdType').value = document.getElementById('frmPhotoIdType:photoIdTypeValue').value ; 
    closePhotoIdTypeWindow(); 
}
;
function closePhotoIdTypeWindow(){
    var modal = document.getElementById('photoIdTypeModal');
    modal.style.display = "none";
}
; 

