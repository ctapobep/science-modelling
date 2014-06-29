package edu.science.biology

/**
 * Pronunciation: http://www.merckmanuals.com/home/resources/pronunciations/index/a.html
 */
enum Dictionary {
    def size = [
            macro          : 'large',
            micro          : 'small',
            'megalo/megaly': 'enlarged']
    def rates = [
            'hyper': 'high/elevated/above',
            'hypo' : 'low/reduced/below',
            'tachy': 'fast/rapid',
            'brady': 'slow/reduced']
    def color = [
            'chloro': 'green',
            'leuk'  : 'white',
            'eryth' : 'red',
            'cyan'  : 'blue']
    def location = [
            'endo/intra': 'inside, within',
            'inter'     : 'between',
            'trans'     : 'across',
            'peri'      : 'around',
            'extra'     : 'outside']
    def testsAndProcedures = [
            echo       : 'using ultrasonic waves',
            electro    : 'using electricity',
            '-ectomy'  : 'removal of',
            '-gram'    : 'picture',
            '-graph(y)': 'process of making an image',
            '-otomy'   : 'making a cut in',
            '-scopy'   : 'using an instrument for viewing',
            '-stomy'   : 'create an opening']
    def problems = [
            'dys-'  : 'now working properly',
            'mal-'  : 'bad, malaria - meant to be meant to spread via air, so = bad air',
            '-emia' : 'blood condition',
            '-itis' : 'inflammation',
            '-osis' : 'condition or disease',
            '-pathy': 'disease']
    def partsOfBody = [
            abdomeno: 'abdomen, peritoneal, belly cavity',
            acro    : ['extremety', 'acromegaly - enlarged arms and feet'],
            adeno   : 'gland, adenoma - a tumor of some gland',
            angio   : ['vessel', 'angiogram - a graph of vasculature'],
            veno    : ['veins'], PLEBO: ['veins'],
            arthro  : ['joint', 'arthritis - inflamation of joints'],
            cardio  : ['heart'],
            chondro : ['cartilage'],
            cysto   : ['bladder, sac', 'cystitis - bladder infection'],
            cyto    : ['cell'],
            dento   : ['tooth'],
            dermato : ['skin'], DERMO: ['skin'],

            duodemo : ['duodenum'],
            stomato : ['mouth', 'stomatitis - inflamation inside the mouth'],
            colo    : ['column, large intenstine'],

            gastro  : ['stomach', 'gistritis - inflamation of stomach'],
            hepato  : ['liver', 'hepatoma - tumor of the liver, hepatits - infection of liver'],
            laryngo : ['larynx, voice box', 'laryngitis - inflamation of of larynx'],
            myo     : ['muscle'], SARCO: ['muscle'],
            nephro  : ['kidney'],
            neuro   : ['nerves'],
            osteo   : ['bone'],

            oto     : ['ear'],
            tympano : ['eardrum'],

            patho   : ['disease'],
            pneumono: ['lung'],
            rhino   : ['nose'],
            thoraco : ['thorax, pleural, chest'],
            cephalo : ['head'],
            cervico : ['neck'],
            axilary : ['arm pit']
    ]
  def drugs = [
    ine: ['the drug is usually a base']
  ]
}

