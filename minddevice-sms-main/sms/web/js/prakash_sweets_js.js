

function show_price() {
    dojo.event.topic.publish("show_price");
}


function calculateTotal()
{
    var itemPrice = document.getElementById('itemPrice').value;
    var itemQuantity = document.getElementById('itemQuantity').value;

    document.getElementById('total').readOnly = true;
    document.getElementById('total').value = itemPrice*itemQuantity;

}

function printInvoice() {

    printDivCSS = new String ('<link href="../css/invoiceprintstyle.css" rel="stylesheet" type="text/css">');
    var html = '<HTML>\n<HEAD>\n';

    html += printDivCSS;

    html += '\n</HE' + 'AD>\n<BODY>\n';

    var printReadyElem = document.getElementById("main_content");

    if (printReadyElem != null)
    {
        html += printReadyElem.innerHTML;
    }
    else
    {
        alert("Could not find the printReady section in the HTML");
        return;
    }

    html += '\n</BO' + 'DY>\n</HT' + 'ML>';

    //var printWin = window.open("","printSpecial");
    //printWin.document.open();
    //printWin.document.write(html);
    //printWin.document.close();
    //printWin.print();


    window.frames["print_frame"].document.body.innerHTML=html;
    window.frames["print_frame"].window.focus();
    window.frames["print_frame"].window.print();


}





