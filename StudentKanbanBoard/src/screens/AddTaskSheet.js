import React from 'react'
import { View, StyleSheet, Text } from 'react-native'
import Button from '../components/Button'
import { NavigationContainer } from '@react-navigation/native'
import TextInput from '../components/TextInput';
import {Picker} from '@react-native-picker/picker';
import Background from '../components/Background'

const TaskState = { inProgress: 'InProgress', completed: 'Completed', toDo: 'ToDo'};

export default function AddTaskSheet({ navigation, route }) {
  const [newTask, setNewTask] = React.useState('');
  const [newTaskTitle, setNewTitle] = React.useState('');
  const [newTaskCourse, setNewCourse] = React.useState('');

  return (
    <View>
    <TextInput style={{marginHorizontal:20}} value={newTaskTitle} onChangeText={setNewTitle} label="Title" />
    <TextInput style={{marginHorizontal:20}} value={newTaskCourse} onChangeText={setNewCourse} placeholder="CS3354" label="Course Code" />
    {/*<Picker>
      <Picker.Item label="To Do" value="toDo" />
      <Picker.Item label="In Progress" value="toDo" />
  </Picker>*/}
  <Button mode="contained" style={{margin:20, width:'90%'}} title="Create" onPress={() => {
          navigation.navigate({
            name: 'Dashboard',
            params: { newTask: {
              title: newTaskTitle,
              class: newTaskCourse,
              state: TaskState.toDo
            } },
            merge: true,
          });
        }}>
        Create
      </Button>
    </View>
  )
}
