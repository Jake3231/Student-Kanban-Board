import React from 'react'
import { View, StyleSheet, Text } from 'react-native'

export default function TaskCard({title, color}) {
  return (
    <View>
      <Text style={{backgroundColor:color, opacity: 0.8, width:'80%', alignContent:'center', justifyContent:'center', flex:1, fontSize:16, textAlign:'left', overflow:'hidden', borderRadius: 7, padding: 5, marginVertical: 5, marginHorizontal: '10%'}}>{title}</Text>
    </View>
  )
}
