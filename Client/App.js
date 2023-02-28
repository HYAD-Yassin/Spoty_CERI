import React from 'react';
import {
  StyleSheet,
  Button,
  View,
  SafeAreaView,
  Text,
  Image,
  Alert,
} from 'react-native';

const Separator = () => <View style={styles.separator} />;

const App = () => (
  <SafeAreaView style={styles.container}>
    <View>

    <Image source={require('./assets/guy-listening-music-alone-wallpaper-3840x2400_9.jpg')} style={{width: 1000, height: 750}} />


      <Text style={styles.title}>
      Hello To Spoty CERI !!
      </Text>
      <Button
        title="Piloter"
        onPress={() => Alert.alert('Simple Button pressed')}
      />

   
    </View>


 




  
  </SafeAreaView>
);

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    marginHorizontal: 16,
  },
  title: {
    textAlign: 'center',
    marginVertical: 8,
  },
  fixToText: {
    flexDirection: 'row',
    justifyContent: 'space-between',
  },
  separator: {
    marginVertical: 8,
    borderBottomColor: '#737373',
    borderBottomWidth: StyleSheet.hairlineWidth,
  },
});



export default App;