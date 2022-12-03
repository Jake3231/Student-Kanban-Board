import React from 'react'
import { Provider } from 'react-native-paper'
import { Button } from 'react-native';
import { NavigationContainer } from '@react-navigation/native'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import { AntDesign } from '@expo/vector-icons';
import { theme } from './src/core/theme'
import {
  StartScreen,
  LoginScreen,
  RegisterScreen,
  ResetPasswordScreen,
  Dashboard,
  AddTaskSheet,
} from './src/screens'
import { TouchableOpacity } from 'react-native-gesture-handler';

const Stack = createNativeStackNavigator()

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
          <Stack.Screen name="AddTaskSheet" options={{ presentation: 'modal', headerShown:true, headerTitle:'Add Task' }} component={AddTaskSheet} />
          <Stack.Screen options={({ navigation }) => ({
            headerShown: true,
          headerLargeTitle: true,
          headerLeft: () => (
            <TouchableOpacity style={{marginLeft:10}} onPress={() => navigation.navigate('AddTaskSheet')}>
              <AntDesign name="plus" size={24} color="purple" />
            </TouchableOpacity>
            //<Button title="+"  onPress={() => navigation.navigate('AddTaskSheet')} /> //TOOD: Investigate proper symbol here
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
