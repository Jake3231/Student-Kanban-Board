import React from 'react'
import { Provider } from 'react-native-paper'
import { Button } from 'react-native';
import { NavigationContainer } from '@react-navigation/native'
import { createStackNavigator } from '@react-navigation/stack'
import { theme } from './src/core/theme'
import {
  StartScreen,
  LoginScreen,
  RegisterScreen,
  ResetPasswordScreen,
  Dashboard,
  AddTaskSheet
} from './src/screens'

//import AddTaskSheet from './src/screens' //Workaround

const Stack = createStackNavigator()

export default function App() {
  return (
    <Provider theme={theme}>
      <NavigationContainer>
        <Stack.Navigator
          initialRouteName="StartScreen"
          screenOptions={{
            headerShown: false,
          }}
        >
          <Stack.Screen name="StartScreen" component={StartScreen} />
          <Stack.Screen name="LoginScreen" component={LoginScreen} />
          <Stack.Screen name="RegisterScreen" component={RegisterScreen} />
          <Stack.Screen name="AddTask" component={AddTaskSheet} />
          <Stack.Screen options={({ navigation }) => ({
            headerShown: true,
          headerLargeTitle: true,
          headerLeft: () => (
            <Button title="+"  onPress={() => navigation.navigate('AddTask')} /> //TOOD: Investigate proper symbol here
          ),
          headerTitle: "Kanban Board"
        })} name="Dashboard" component={Dashboard} />
          <Stack.Screen
            name="ResetPasswordScreen"
            component={ResetPasswordScreen}
          />
        </Stack.Navigator>
      </NavigationContainer>
    </Provider>
  )
}
