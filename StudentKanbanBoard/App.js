import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, Button } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import HomePage from './Homepage'
import AddTaskSheet from './AddTaskSheet'

const Stack = createNativeStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen options={({ navigation }) => ({
          headerLargeTitle: true,
          headerLeft: () => (
            <Button title="+"  onPress={() => navigation.navigate('Add Task')} /> //TOOD: Investigate proper symbol here
          )
        })} name="Kanban Board" component={HomePage} />
        <Stack.Group screenOptions={{ presentation: 'modal' }}>
        <Stack.Screen name="Add Task" component={AddTaskSheet} />
      </Stack.Group>
    </Stack.Navigator>
    </NavigationContainer>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
