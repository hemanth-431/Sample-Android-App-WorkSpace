import 'package:flutter/material.dart';

class NewTransaction extends StatefulWidget {
  final Function addTx;

  NewTransaction(this.addTx);

  @override
  _NewTransState createState()=>_NewTransState();

}

class _NewTransState extends State<NewTransaction>
{

  final titleController = TextEditingController();
  final amountController = TextEditingController();


  void submitData() {
    final enteredTitle = titleController.text;
    final enteredAmount = double.parse(amountController.text);

    if (enteredTitle.isEmpty || enteredAmount <= 0) {
      return;
    }

    widget.addTx(
      enteredTitle,
      enteredAmount,
    );
    Navigator.of(context).pop();
  }

  @override
  Widget build(BuildContext context) {
    return Card(
      elevation: 5,
      child: Container(
        padding: EdgeInsets.all(10),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.end,
          children: <Widget>[
            TextField(
              decoration: InputDecoration(labelText: 'Title'),
              controller: titleController,
              onSubmitted: (_) => submitData(),
              // onChanged: (val) {
              //   titleInput = val;
              // },
            ),
            TextField(
              decoration: InputDecoration(labelText: 'Amount'),
              controller: amountController,
              keyboardType: TextInputType.number,
              onSubmitted: (_) => submitData(),
              // onChanged: (val) => amountInput = val,
            ),
            Container(
              height: 70,
              child: Row(
                children: <Widget>[Text('No Data Chosen!'),
                  FlatButton(
                    textColor: Theme.of(context).primaryColor,
                    child: Text('Choose Data',style: TextStyle(fontWeight: FontWeight.bold),),
                    onPressed: (){},)],
              ),
            ),
            RaisedButton (
              child: Text('Add Transaction',),
              color: Colors.purple,
              onPressed: submitData,
            ),
          ],
        ),
      ),
    );
  }
}

