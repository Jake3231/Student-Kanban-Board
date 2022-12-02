import React from 'react'
import { View, StyleSheet, Text } from 'react-native'

export default function TaskCard({title, color}) {
  return (
    <View style={{backgroundColor:color, width:'88%', alignContent:'center', justifyContent:'center', flex:1, textAlign:'left', overflow:'hidden', borderRadius: 7, padding: 10, marginVertical: 5, marginHorizontal: '6%'}}>
      <Text style={{fontSize:17}}>{title}</Text>
      {/*<Text style={{fontSize:12, fontWeight:'400'}}>12/2/22</Text>*/}
    </View>
  )
}
