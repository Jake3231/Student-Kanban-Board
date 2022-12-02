import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, ScrollView, Dimensions } from 'react-native';
import {
  SafeAreaView,
  SafeAreaProvider,
  SafeAreaInsetsContext,
  useSafeAreaInsets,
  initialWindowMetrics,
} from 'react-native-safe-area-context';

const tasks = [
  "Test",
  "Item Here"
];

export default function Dashboard({navigation}) {
    return (
        <View style={{flex:1}}>
      <ScrollView style={{flexGrow:1, width: Dimensions.get('window').width, marginTop: 10}}>
      <Text style={{fontSize:20, marginLeft: 15}}>In Progress</Text>
      <Text style={{fontSize:20, marginLeft: 15}}>To Do</Text>
              {tasks.map((item) => {
                return (
                <Text style={{backgroundColor:'rgba(52, 52, 52, 0.2)', width:'80%', alignContent:'center', justifyContent:'center', flex:1, fontSize:16, textAlign:'center', overflow:'hidden', borderRadius: 7, paddingVertical:5, marginVertical: 5, marginHorizontal: '10%'}}>{item}</Text>
                )

              })}
        <Text style={{fontSize:20, marginLeft: 15}}>Completed</Text>
      </ScrollView>
        <StatusBar style="auto" />
        </View>
    );
  }