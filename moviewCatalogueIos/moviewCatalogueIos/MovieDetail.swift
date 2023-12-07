//
//  MovieDetail.swift
//  moviewCatalogueIos
//
//  Created by Quipper on 22/07/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct MovieDetail: View {
    var movieDetail:Result
    @Environment(\.presentationMode) var presentationMode: Binding<PresentationMode>
    var body: some View {
        ScrollView{
            VStack{
                if #available(iOS 15.0, *) {
                    AsyncImage(url: URL(string:"https://image.tmdb.org/t/p/w500"+movieDetail.poster_path)) { image in
                        VStack {
                            image
                                .resizable()
                                .aspectRatio(contentMode: .fill)
                                .frame(minWidth:0,maxWidth:.infinity,minHeight:100)
                            
                            Text(movieDetail.title)
                                .font(.system(size: 16))
                        }.frame( alignment: Alignment.center)
                            .padding(EdgeInsets(top: 8, leading: 4, bottom: 8, trailing: 4))
                    } placeholder: {
                        VStack {
                            Image(systemName: "photo")
                                .imageScale(.large)
                                .frame(width: 110, height: 110)
                            
                            Text(movieDetail.title)
                                .padding(EdgeInsets(top: 8, leading: 8, bottom: 8, trailing: 8))
                        }
                    }
                } else {
                    // Fallback on earlier versions
                }
            }
        }.navigationBarBackButtonHidden(true)
            .navigationBarItems(leading:Button(action:{
                presentationMode.wrappedValue.dismiss()
            }){
                Text("Back")
            })
            .navigationBarTitle("Movie Detail",displayMode:.inline)
    }
}

