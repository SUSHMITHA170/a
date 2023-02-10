import 'package:audioplayers/audioplayers.dart';
import 'package:flutter/material.dart';


void main() {
  runApp(MaterialApp(
    home: Scaffold(
      appBar: AppBar(title: Text('XYLOPHONE170'),
        centerTitle: true,
      ),
      body: Xylo(),
    ),
  ));
}

class Xylo extends StatefulWidget {
  const Xylo({Key? key}) : super(key: key);

  @override
  State<Xylo> createState() => _XyloState();
}

class _XyloState extends State<Xylo> {

  void playsound(int i)
  {
    final player = AudioCache();
    player.play("note$i.wav");
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.stretch,
      children: [
        Expanded(child: TextButton(
          style: TextButton.styleFrom(backgroundColor: Colors.red),
          onPressed: ()
          {
            playsound(1);
          },
          child: Text('First'),
        ),
        ),

        Expanded(child: TextButton(
          style: TextButton.styleFrom(backgroundColor: Colors.red),
          onPressed: ()
          {
            playsound(2);
          },
          child: Text('Second'),
        ),
        ),

        Expanded(child: TextButton(
          style: TextButton.styleFrom(backgroundColor: Colors.red),
          onPressed: ()
          {
            playsound(3);
          },
          child: Text('Third'),
        ),
        ),

        Expanded(child: TextButton(
          style: TextButton.styleFrom(backgroundColor: Colors.red),
          onPressed: ()
          {
            playsound(4);
          },
          child: Text('Fourth'),
        ),
        ),

        Expanded(child: TextButton(
          style: TextButton.styleFrom(backgroundColor: Colors.red),
          onPressed: ()
          {
            playsound(5);
          },
          child: Text('Fifth'),
        ),
        ),

        Expanded(child: TextButton(
          style: TextButton.styleFrom(backgroundColor: Colors.red),
          onPressed: ()
          {
            playsound(6);
          },
          child: Text('Sixth'),
        ),
        ),

        Expanded(child: TextButton(
          style: TextButton.styleFrom(backgroundColor: Colors.red),
          onPressed: ()
          {
            playsound(7);
          },
          child: Text('Seven'),
        ),
        ),


      ],

    );
  }
}

