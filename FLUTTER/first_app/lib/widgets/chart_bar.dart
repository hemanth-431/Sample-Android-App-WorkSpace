import 'package:flutter/material.dart';
class chartbar extends StatelessWidget {
  final String labrl;
  final double spendingamount;
  final double spendingper;
  chartbar(this.labrl,this.spendingamount,this.spendingper);

  @override
  Widget build(BuildContext context) {

    return Column(
      children: <Widget>[
        FittedBox(child: Text('\$${spendingamount.toStringAsFixed(0)}')),
        SizedBox(height: 4,),

        Container(
          height: 60,
          width: 10,
          child: Stack(children: <Widget>[
            Container(decoration: BoxDecoration(border: Border.all(color: Colors.grey,width: 1.0),
              color:Color.fromRGBO(220, 220, 220, 1),
              borderRadius: BorderRadius.circular(10)
              ,              ),),
            FractionallySizedBox(heightFactor: spendingper,child: Container(decoration: BoxDecoration(color: Theme.of(context).primaryColor,borderRadius: BorderRadius.circular(10)),
            ),),
          ],),
        ),
        SizedBox(height: 4,),
        Text(labrl),
      ],
    );
  }
}
