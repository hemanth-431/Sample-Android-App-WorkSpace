import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:first_app/models/transaction.dart';
import 'package:first_app/widgets/chart_bar.dart';


class Chart extends StatelessWidget {
  final List<Transaction> recenttrans;
  Chart(this.recenttrans);
  List<Map<String,Object>>get groupedTransactionValues{
    return List.generate(7, (index){
      final weekday=DateTime.now().subtract(Duration(days: index),);
      var totalsum=0.0;
      for(var i=0;i< recenttrans.length;i++){
        if(recenttrans[i].date.day==weekday.day && recenttrans[i].date.month==weekday.month && recenttrans[i].date.year==weekday.year)
        {
          totalsum += recenttrans[i].amount;
        }
      }
      print(DateFormat.E().format(weekday));
      print(totalsum);
      return{'day': DateFormat.E().format(weekday).substring(0,1),'amount':totalsum};
    }).reversed.toList();
  }
  double get maxsp
  {
    return groupedTransactionValues.fold(0.0, (sum,item){
      return sum+item['amount'];
    });
  }
  @override
  Widget build(BuildContext context) {
    return Card(elevation: 6,margin: EdgeInsets.all(20),
      child: Container(
        padding: EdgeInsets.all(10),
        child: Row(mainAxisAlignment: MainAxisAlignment.spaceAround, children: groupedTransactionValues.map((data){
          return Flexible(fit: FlexFit.loose,child: chartbar(data['day'],data['amount'],maxsp==0.0 ? 0.0:(data['amount'] as double)/maxsp));
        }).toList()

          ,),
      ),
    );
  }
}

